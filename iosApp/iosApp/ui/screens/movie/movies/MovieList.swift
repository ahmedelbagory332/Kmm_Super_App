//
//  MovieList.swift
//  iosApp
//
//  Created by ahmed elbagory on 11/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared


struct MovieList: View {
    @ObservedObject var moviesViewModel = MoviesViewModel()
    var genresId: String = ""
    
    init(genresId: String) {
        self.genresId = genresId
        self.moviesViewModel.loadMovies(foreceLoad: false,genresId: genresId)
    }
    
    
    let gridColumns: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16), count: 2)
    
    var body: some View {
        
        MovieGridView(viewModel: moviesViewModel, genresId: genresId, gridColumns: gridColumns)
        
    }
}

struct MovieGridView: View {
    @ObservedObject var viewModel: MoviesViewModel
    var genresId: String = ""
    var gridColumns: [GridItem]
    
    
    var body: some View {
        LazyVGrid(columns: gridColumns, spacing: 16) {
            ForEach(viewModel.state.movies, id: \.id) { movie in
                NavigationLink(destination:  DetailsScreen(movie: movie)) {
                    MovieListItem(movie: movie)
                        .onAppear {
                            viewModel.loadMoreContent(currentItem: movie, genresId: genresId)
                        }
                    
                }
                
                
            }
            
            
            if viewModel.state.loading {
                Section(footer: LoadingIndicator()){}
            }
        }
        .padding(.horizontal, 12)
    }
}



