//
//  HomeScreen.swift
//  iosApp
//
//  Created by ahmed elbagory on 10/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

import SwiftUI
import shared

struct HomeScreen: View {
    @StateObject var viewModel = HomeViewModel()
    
    let gridColumns: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16), count: 2)
    
    @Environment(\.presentationMode) var presentationMode: Binding<PresentationMode>

       var btnBack : some View { Button(action: {
           self.presentationMode.wrappedValue.dismiss()
           }) {
               HStack {
               Image("ic_back") // set image here
                   .aspectRatio(contentMode: .fit)
                   .foregroundColor(.white)
                   Text("Go back")
               }
           }
       }
    
    var body: some View {
        NavigationStack{
            VStack {
                Text("KMM Supper App")
                    .font(.headline)
                    .foregroundColor(.white)
                    .padding()
                
                ScrollView{

                    LazyVGrid(columns: gridColumns){
                        ForEach(viewModel.state.homeList, id: \.self ){homeItem in
                            NavigationLink(destination: destinationView(for: homeItem)) {
                                HomeItem(homeModel: homeItem)
                            }
                            
                        }
        
                    }
                    .padding(.horizontal, 12)
                    .padding(.vertical, 32)
                    
                }        
                .frame(maxWidth: .infinity, maxHeight: .infinity)
                .background(Color.white)
                .cornerRadius(50)
                .overlay( 
                    RoundedRectangle(cornerRadius: 50)
                        .stroke( lineWidth: 0)
                )
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .background(Color.blue)
            .ignoresSafeArea(edges: [.bottom,.horizontal])
            .navigationBarHidden(true)
            .navigationBarTitle(Text("Home"))
        }

    }
}

@ViewBuilder
private func destinationView(for homeItem: HomeModel) -> some View {
    switch homeItem.route {
    case Routers().launchesRoute:
        LaunchesScreen()
    case Routers().moviesRoute:
        MoviesScreen()
    default:
        EmptyView()
    }
}
