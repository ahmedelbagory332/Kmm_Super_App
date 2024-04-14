//
//  MoviesViewModel.swift
//  iosApp
//
//  Created by ahmed elbagory on 11/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//


import Foundation
import shared

class MoviesViewModel: ObservableObject {
    private var moviesUseCase = DIHelper().moviesUseCase

    @Published private var moviesState = MoviesState()
    var state: MoviesState {
        return moviesState
    }
    
    private var totalPages : Int = 0
    private var currentPage : Int = 1

    
    func loadMovies(foreceLoad : Bool,genresId: String)  {
        
        if(foreceLoad==true){
            currentPage = 1
            self.moviesState.movies.removeAll()
            
        }
        
        DispatchQueue.main.async {
            Task {
                if self.moviesState.loading {
                    return
                }
                
                do {
                    self.moviesState.loading = true
                    let resultMovies = try await self.moviesUseCase.invoke(page : Int32(self.currentPage) , genresId : genresId)
                    let moviesList = (self.currentPage == 1) ? resultMovies.moveList : (self.moviesState.movies + resultMovies.moveList)
                    
                    
                    self.moviesState.loading = false
                    self.moviesState.loadFinished = moviesList.isEmpty
                    self.moviesState.movies =  moviesList
                    self.totalPages = Int(resultMovies.totalPages)
                    
                    
                } catch {
                    
                    self.moviesState.loading = false
                    self.moviesState.loadFinished = true
                    self.moviesState.errorMessage = error.localizedDescription
                    
                }
            }
        }
    }
    
    func loadMoreContent(currentItem item: MovieItem,genresId: String) {
        if state.movies.last == item, (currentPage < totalPages) {
            currentPage += 1
            loadMovies(foreceLoad: false,genresId: genresId)
        }
    }


    
}

