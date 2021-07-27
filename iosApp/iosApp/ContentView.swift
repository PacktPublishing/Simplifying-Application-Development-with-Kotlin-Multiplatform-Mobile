import SwiftUI
import shared

struct ContentView: View {
    
    @ObservedObject private var viewModel: MainViewModel
    
    init() {
        KoinModuleKt.doInitKoin()
        viewModel = MainViewModel.init()
    }
    
    var body: some View {
        VStack{
            Toggle("Filter favourites", isOn: $viewModel.shouldFilterFavourites)
                .padding(16)
            Button("Refresh breeds", action: { viewModel.fetchData()} )
                .frame(alignment: .center)
                .padding(.bottom, 16)
            ZStack{
                switch viewModel.state {
                case MainViewModel.State.LOADING:
                    ProgressView()
                        .frame(alignment:.center)
                case MainViewModel.State.NORMAL:
                    BreedsGridUIView(breeds: viewModel.filteredBreeds, onFavouriteTapped: viewModel.onFavouriteTapped)
                case MainViewModel.State.EMPTY:
                    Text("Ooops looks like there are no breeds")
                        .frame(alignment: .center)
                        .font(.headline)
                case MainViewModel.State.ERROR:
                    Text("Ooops something went wrong...")
                        .frame(alignment: .center)
                        .font(.headline)
                }
            }
        }
    }
}
