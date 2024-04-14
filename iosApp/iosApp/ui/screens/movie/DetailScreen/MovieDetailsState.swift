//
//  MovieDetailsState.swift
//  iosApp
//
//  Created by ahmed elbagory on 14/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

import Foundation
import shared

struct MovieDetailsState {
    var loading: Bool
    var movie: MovieDetailsModel
    var errorMessage: String
    
    init(
        loading: Bool = false,
        movie: MovieDetailsModel = 
        MovieDetailsModel.init( id: 1,
           posterUrl: "",
           name: "",
           tagline: "",
           releaseDate: "",
           runtime: 0,
           overview: "",
           genres: [],productionCompanies:[]),
        errorMessage: String = "") {
        self.loading = loading
        self.movie = movie
        self.errorMessage = errorMessage
    }
}

