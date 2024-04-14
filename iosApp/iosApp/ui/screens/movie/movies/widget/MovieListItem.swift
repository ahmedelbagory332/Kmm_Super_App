//
//  MovieListItem.swift
//  iosApp
//
//  Created by ahmed elbagory on 11/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct MovieListItem: View {
    let movie: MovieItem
    
    var body: some View {
        
        VStack {
            
            
            AsyncImage(
                url: URL(string: Constant.imageBaseUrl + (movie.posterUrl ?? ""))) { image in
                    image
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(height: 200)
                        .clipShape(RoundedRectangle(cornerRadius: 8))
                        .shadow(radius: 4)
                } placeholder: {
                    ProgressView()
                }
            
            Text(movie.name)
                .font(.body)
                .fontWeight(.bold)
                .multilineTextAlignment(.center)
                .lineLimit(1)
                .padding(.horizontal)
        }
        
        .buttonStyle(PlainButtonStyle())
        .padding()
    }
}
