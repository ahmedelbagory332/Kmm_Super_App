//
//  GenreViewModel.swift
//  iosApp
//
//  Created by ahmed elbagory on 11/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

class GenreViewModel: ObservableObject {
    private var genreUseCase = DIHelper().genreUseCase
    
    @Published private var genreState = GenreState(isLoading: false, genres: [], error: "")
    var state: GenreState {
        return genreState
    }
    
    private var resultList: [GenreItemModel] = []
    
    @Published var selectedGenre: GenreItemModel = GenreItemModel(id: -1, name: "")

    func setSelectedGenre(_ selectedGenre: GenreItemModel) {
        self.selectedGenre = selectedGenre
    }

    
    init() {
        
        self.getGenre()
        
    }
    
    func getGenre() {
        
        self.genreState.isLoading = true
        DispatchQueue.main.async {
            Task {
                do {
                    self.resultList = try await self.genreUseCase.invoke().genres
                    DispatchQueue.main.async {
                        self.genreState.isLoading = false
                        self.genreState.genres = self.resultList
                    }
                } catch {
                    DispatchQueue.main.async {
                        self.genreState.isLoading = false
                        
                        self.genreState.error = error.localizedDescription
                        
                    }
                }
            }
        }    }
    
}


