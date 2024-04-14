//
//  MoviesState.swift
//  iosApp
//
//  Created by ahmed elbagory on 11/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
struct MoviesState {
    var loading: Bool
    var movies: [MovieItem]
    var errorMessage: String
    var loadFinished: Bool
    
    init(loading: Bool = false, movies: [MovieItem] = [], errorMessage: String = "", loadFinished: Bool = false) {
        self.loading = loading
        self.movies = movies
        self.errorMessage = errorMessage
        self.loadFinished = loadFinished
    }
}
