
# Android Challenge

## Functionality

The app displays the total balance and transactions from blockchain endpoint.
When an error is happening user is shown a `Snackbar`. There is a button to refresh data.

## Structure
The project was built with Clean Architecture in mind, MVVM for presentation, and Dependency Injection
bind abstractions.

There are multiple approaches to Clean Architecture, I chose 5 layers, each represented by a package

* presentation  - ui, threading
* use case      - business logic, mapping
* domain        - common definitions of core objects and interfaces
* data          - right now only repository implementation
* framework     - code dependent on external framework

And a separate package for DI.

This approach enables the code to be very flexible. For example, in order to use a different api we
would only need to change classes in the `framework` package. Other layers are equally flexible, as
they only depend on entities and interfaces defined in the `domain` package.

This is clearly over engineered for a project of this size, but I do believe that benefits of this
structure are significant on a larger one.

### Presentation
In the presentation layer I used the MVVM pattern to bind use cases with ui events. 

I use the `groupie` library for displaying a list, it really simplifies creating view models and 
adapters.

The ViewModel is using LiveData for caching ui data for orientation changes, so no serialization 
in `onSaveInstanceState` is necessary.

The MainFragmentViewModel is also responsible for arranging the right threads for data retrieval.

### Usecase / interactor
Encapsulates data access and maps repository responses to more suitable format for displaying.


### Domain
Entity objects helps to decouple business logic from the api, and break reliance between the 
different modules.

### Data
Only simple caching mechanism is implemented here right now. Only depends on abstractions
defined in Domain.

### Framework
Network access classes are here, and data classes defined by the Blockchain api. 

The decoupling of layers comes at a price of having to transform api objects into domain ones.
This is encapsulated and unit tested with the `BitcoinWalletMapper` class

`BlockchainDataSource` is providing an abstraction for accessing the api, mapping to domain object,
so it can be used as an input for the `CachingRepository`

### DI
I use constructor injection wherever possible in the project.
In some very simple cases I didn't create a hard implementation for certain necessary objects, 
see rx scheduler.

## Improvements
UI could look better, UI tests would also be nice, though all the logic is unit tested.
Loading could be prettier. In a larger project the package structure would be different as well