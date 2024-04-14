//
//  MovieDetailsViewModel.swift
//  iosApp
//
//  Created by ahmed elbagory on 14/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

class MovieDetailsViewModel: ObservableObject {
    private var movieDetailsUseCase = DIHelper().movieDetailsUseCase
    var movieId: Int64 = 0 

    @Published private var movieDetailsState = MovieDetailsState()
    var state: MovieDetailsState {
        return movieDetailsState
    }
    

       
       init(movieId: Int64) {
           self.movieId = movieId   
       }
       
    
    
    func loadMovie()  {
        
        DispatchQueue.main.async {
            Task {

                do {
                    self.movieDetailsState.loading = true

                    let resultMovie = try await self.movieDetailsUseCase.invoke(id:String(self.movieId))
                    
                    self.movieDetailsState.loading = false
                
                    self.movieDetailsState.movie =  resultMovie
                    
                
                } catch {
                    
                    self.movieDetailsState.loading = false
                    self.movieDetailsState.errorMessage = error.localizedDescription
                    
                }
            }
        }
    }
    
    
}


