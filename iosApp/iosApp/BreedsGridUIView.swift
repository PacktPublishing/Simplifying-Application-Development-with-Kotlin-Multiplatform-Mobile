//
//  BreedsGridUIView.swift
//  iosApp
//
//  Created by Robert Nagy on 26/07/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct BreedsGridUIView: View {
    var breeds: Array<Breed>
    var onFavouriteTapped: (Breed) -> Void = {_ in }
    
    var body: some View {
        let columns = [
            GridItem(.flexible(minimum: 128, maximum: 256), spacing: 16),
            GridItem(.flexible(minimum: 128, maximum: 256), spacing: 16)
        ]
        ScrollView{
            LazyVGrid(columns: columns, spacing: 16){
                ForEach(breeds, id: \.name){ breed in
                    BreedUIView(breed: breed, onFavouriteTapped: onFavouriteTapped)
                }
            }.padding(.horizontal, 16)
        }
    }
}

struct BreedsGridUIView_Previews: PreviewProvider {
    static var previews: some View {
        BreedsGridUIView(breeds: Array<Breed>(
            arrayLiteral:
                Breed(
                    name: "beagle",
                    imageUrl: "https://images.dog.ceo//breeds//beagle//n02088364_161.jpg",
                    isFavourite: false
                ),
            Breed(
                name: "affenpinscher",
                imageUrl: "https://images.dog.ceo//breeds//affenpinscher//n02110627_3001.jpg",
                isFavourite: true
            )
        ))
    }
}

