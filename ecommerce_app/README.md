# E-commerce Customer Application

A modern, high-performance Android application for customers built with **Jetpack Compose**. This app provides a seamless shopping experience with real-time updates and secure payment integration.

## 🚀 Recent Updates
- **Modular Architecture**: Refactored the project into a modular structure (`app` and `core`) to improve maintainability and build times.
- **Enhanced Core Module**: Centralized network, database, and repository logic into the `core` module.
- **UI/UX Polishing**: Refined layouts and removed redundant components for a smoother user experience.
- **Improved Navigation**: Integrated modern navigation suite for better flow.

## 🏗 Architecture
The project follows **Clean Architecture** and **MVVM** patterns, divided into:
- **`:app`**: Contains the UI layer (Compose), ViewModels, and UI-specific utilities.
- **`:core`**: The engine of the app, containing:
    - **Data Layer**: Repositories, DTOs, Room Database, and API services.
    - **Domain Layer**: Business logic and domain models.
    - **DI**: Dependency injection modules using Koin.

## 🛠 Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **DI Framework**: Koin
- **Asynchronous**: Kotlin Coroutines & Flow
- **Local Database**: Room
- **Payments**: Stripe SDK
- **Real-time**: SignalR
- **Maps & Location**: Google Maps SDK & Play Services Location
- **Images**: Coil
- **Push Notifications**: Firebase Cloud Messaging (FCM)

## 📸 Screenshots

![086957f4-13f2-435e-8930-2338deaba78b.png](images/086957f4-13f2-435e-8930-2338deaba78b.png)
![0ccf0b98-81cf-44e3-8c41-c9f19906a5ec.png](images/0ccf0b98-81cf-44e3-8c41-c9f19906a5ec.png)
![2158a84e-0f25-47c1-9bdd-2df1521e6e1b.png](images/2158a84e-0f25-47c1-9bdd-2df1521e6e1b.png)
![318da45a-7b9b-444b-8fdc-99781725c030.png](images/318da45a-7b9b-444b-8fdc-99781725c030.png)
![3c959c30-9db6-4b62-8d6d-6382290de25e.png](images/3c959c30-9db6-4b62-8d6d-6382290de25e.png)
![40caffaa-a536-4660-a8b6-68a6cf445aa6.png](images/40caffaa-a536-4660-a8b6-68a6cf445aa6.png)
![61dfdad1-8b8e-41b6-9559-4d10b4079832.png](images/61dfdad1-8b8e-41b6-9559-4d10b4079832.png)
![74fc77b2-026b-492d-b485-74ba9e9807bf.png](images/74fc77b2-026b-492d-b485-74ba9e9807bf.png)
![80f4c46e-7cf4-46ab-8478-f3f63c72b5c5.png](images/80f4c46e-7cf4-46ab-8478-f3f63c72b5c5.png)
![82ac460f-c66e-40b1-b130-3d47017d784a.png](images/82ac460f-c66e-40b1-b130-3d47017d784a.png)
![99cd6653-9241-41ad-becf-0a0ca6e9ab85.png](images/99cd6653-9241-41ad-becf-0a0ca6e9ab85.png)
![b8b548e5-fb25-41e9-b6db-f15f3af3dda5.png](images/b8b548e5-fb25-41e9-b6db-f15f3af3dda5.png)
