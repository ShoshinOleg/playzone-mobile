import SwiftUI
import SharedSDK

struct ContentView: View {
//	let greet = Greeting().greet()
   private let viewModel = LoginViewModel()

	var body: some View {
        Button {
            viewModel.obtainEvent(viewEvent: .LoginClick())
        } label: {
            Text("Click Me")
        }
		Text("Hello, iOS")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
