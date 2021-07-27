//
//  MainViewModel.swift
//  iosApp
//
//  Created by Robert Nagy on 21/07/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesRxSwift
import RxSwift
import Combine

class MainViewModel: ObservableObject {
    
    private let repository = BreedsRepository.init()
    private let getBreeds = GetBreedsUseCase.init()
    private let fetchBreeds = FetchBreedsUseCase.init()
    private let onToggleFavouriteState = ToggleFavouriteStateUseCase.init()
    
    @Published
    private(set) var state = State.LOADING
    
    @Published
    var shouldFilterFavourites = false
    
    @Published
    private(set) var filteredBreeds: [Breed] = []
    
    @Published
    private var breeds: [Breed] = []
    
    private let disposeBag = DisposeBag()
    
    init() {
       createObservable(for: repository.breedsNative).subscribe(onNext: { breeds in
            DispatchQueue.main.async {
                self.breeds = breeds
            }
        }).disposed(by: disposeBag)

        $breeds.combineLatest($shouldFilterFavourites, { breeds, shouldFilterFavourites -> [Breed] in
            var result: [Breed] = []
            if(shouldFilterFavourites){
                result.append(contentsOf: breeds.filter{ $0.isFavourite })
            } else {
                result.append(contentsOf: breeds)
            }
            if(result.isEmpty){
                self.state = State.EMPTY
            } else {
                self.state = State.NORMAL
            }
            return result
        }).assign(to: &$filteredBreeds)
        
        getData()
    }
    
    func getData(){
        state = State.LOADING
        
        createSingle(for: getBreeds.invokeNative()).subscribe(onSuccess: { _ in
            DispatchQueue.main.async {
                self.state = State.NORMAL
            }
        }, onFailure: { error in
            DispatchQueue.main.async {
                self.state = State.ERROR
            }
        }).disposed(by: disposeBag)
    }
    
    func fetchData() {
        state = State.LOADING
        
        createSingle(for: fetchBreeds.invokeNative()).subscribe(onSuccess: { _ in
            DispatchQueue.main.async {
                self.state = State.NORMAL
            }
        }, onFailure: { error in
            DispatchQueue.main.async {
                self.state = State.ERROR
            }
        }).disposed(by: disposeBag)
    }
    
    func onFavouriteTapped(breed: Breed){
        createSingle(for: onToggleFavouriteState.invokeNative(breed: breed)).subscribe(onFailure: { error in
           // We're going ignoring the failure, as it will be represented by the stream of breds
        }).disposed(by: disposeBag)
    }
    
    enum State {
        case NORMAL
        case LOADING
        case ERROR
        case EMPTY
    }
    
}
