//
//  DetailScreen.swift
//  iosApp
//
//  Created by ahmed elbagory on 14/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//


import SwiftUI
import shared
import Foundation


struct DetailsScreen: View {
    @ObservedObject var movieDetailsViewModel: MovieDetailsViewModel
    var movie: MovieItem
    @State private var hasLoadedMovieDetails = false
    
    init(movie: MovieItem) {
        self.movie = movie
        self._movieDetailsViewModel = ObservedObject(wrappedValue: MovieDetailsViewModel(movieId: self.movie.id))

    }
    
    var body: some View {
        if movieDetailsViewModel.state.loading {
            LoadingIndicator()
        } else if !movieDetailsViewModel.state.errorMessage.isEmpty {
            ErrorHolder(error: movieDetailsViewModel.state.errorMessage)
        } else {
            let movie = movieDetailsViewModel.state.movie
            ScrollView {
                VStack() {
                    AsyncImage(url: URL(string: Constant.imageBaseUrl + (movie.posterUrl ?? ""))) { phase in
                        switch phase {
                        case .empty:
                            Image("placeholder")
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(height: 250)
                        case .success(let image):
                            image
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(height: 250)
                        case .failure(let error):
                            Text("Failed to load image: \(error.localizedDescription)")
                        @unknown default:
                            Text("Unknown state")
                        }
                    }
                    .clipShape(Rectangle())
                    .frame(maxWidth: .infinity)
                    .padding(.horizontal)
                    Text(movie.name ?? "")
                        .font(.headline)
                        .multilineTextAlignment(.center)
                        .padding(.horizontal)
                    Text(movie.tagline ?? "")
                        .font(.subheadline)
                        .foregroundColor(.secondary)
                        .multilineTextAlignment(.center)
                        .padding(.horizontal)
                    HStack {
                        Text("Release Date: \(movie.releaseDate ?? "")")
                            .font(.body)
                        Spacer()
                        Text("Duration: \(movie.runtime ?? 1)")
                            .font(.body)
                    }
                    .padding(EdgeInsets(top: 0, leading: 30, bottom: 0, trailing: 30))
                    .frame(maxWidth: .infinity)
                    .padding(.horizontal)
                    
                    Text(movie.overview ?? "")
                        .sectionText()
                    
                    Text("Genres: \(movie.genres!.map { $0.name })")
                        .sectionText()

                    Text("Production Companies: \(movie.productionCompanies!.map { $0.name })")
                        .sectionText()
                       

                }
                .navigationBarTitle("Details Screen")
                .onAppear {
                    if !hasLoadedMovieDetails {
                        movieDetailsViewModel.loadMovie()
                        hasLoadedMovieDetails = true
                    }
                }
            }
            
            
        }
        
        
    }
    
}

extension Text {
    func sectionText() -> some View {
        self
            .font(.body)
            .padding(EdgeInsets(top: 30, leading: 30, bottom: 0, trailing: 30))
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(.horizontal)
    }
}

