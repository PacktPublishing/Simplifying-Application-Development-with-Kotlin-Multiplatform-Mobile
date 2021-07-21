//
//  MainViewModel.swift
//  iosApp
//
//  Created by Robert Nagy on 21/07/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class MainViewModel: ObservableObject{
    
    
    init() {
        FetchBreedsUseCase.init().invoke { breeds, error in
            
        }
    }
}
