//
//  MoviesScreen.swift
//  iosApp
//
//  Created by ahmed elbagory on 11/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct MoviesScreen: View {
    @StateObject var genreViewModel = GenreViewModel()
    @StateObject var moviesViewModel = MoviesViewModel()
    
    let gridColumns: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16), count: 2)
    
    var body: some View {
        ScrollView{
            VStack {
                
                if genreViewModel.state.isLoading {
                    LoadingIndicator()
                } else if !genreViewModel.state.genres.isEmpty {
                    Text("Movie Category : ")
                        .padding(.leading, 8)
                        .font(.body)
                        .fontWeight(.bold)
                        .multilineTextAlignment(.leading)
                        .frame(maxWidth: .infinity, alignment: .topLeading)
                    
                    
                    GenreChips(genres: genreViewModel.state.genres, selectedGenre: genreViewModel.selectedGenre) { genre in
                        genreViewModel.setSelectedGenre(genre)
                      moviesViewModel.loadMovies(foreceLoad: true,genresId: genre.id.description)
                        
                    }
                    
                    if !genreViewModel.selectedGenre.name.isEmpty {
                        MovieList(genresId: genreViewModel.selectedGenre.id.description)
                    } else {
                        PlaceHolder(text: "Please select category",
                                    image: Image("select"))
                        .frame(maxWidth: .infinity,maxHeight:.infinity)
                    }
                } else if !genreViewModel.state.error.isEmpty {
                    ErrorHolder(error: genreViewModel.state.error)
                    
                    
                }
                
                
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .background(Color.white)
            .navigationBarTitle("Movies Screen")            
        }
    }
}
struct GenreChips: View {
    let genres: [GenreItemModel]
    let selectedGenre: GenreItemModel
    let onSelect: (GenreItemModel) -> Void
    
    var body: some View {
        ScrollView(.horizontal, showsIndicators: false) {
            HStack() {
                ForEach(genres,id: \.self) { genre in
                    Chip(
                        genre: genre,
                        selected: selectedGenre.id == genre.id,
                        onSelected: onSelect
                    )
                }
            }
            .padding()
        }
    }
}



