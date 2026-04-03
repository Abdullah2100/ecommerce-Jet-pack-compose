# E-commerce Ecosystem (Jetpack Compose)

This repository contains a e-commerce mobile solution built with modern Android technologies. It consists of two primary applications: a **Customer App** and a **Delivery Man App**, both leveraging **Jetpack Compose** for a modern, reactive UI.

## 📱 Project Overview

The project is structured to handle the entire lifecycle of an order, from customer purchase to final delivery.

### 1. [Customer Application (`ecommerce_app`)](./ecommerce_app)
The customer-facing app allows users to browse products, manage their cart, and make secure payments.
- **Key Features**:
    - **Modular Architecture**: Separate `app` (UI) and `core` (Data/Domain) modules.
    - **Secure Payments**: Integrated with Stripe SDK.
    - **Real-time Tracking**: Powered by SignalR for live order updates.
    - **Location Services**: Google Maps integration for address selection.
    - **Modern UI**: Built entirely with Jetpack Compose and Material 3.

### 2. [Delivery Man Application (`ecommerce-delivery-man`)](./ecommerce-delivery-man)
The delivery-focused app manages order assignments, navigation, and delivery verification.
- **Key Features**:
    - **Real-time Assignments**: Instant notification of new delivery tasks via SignalR.
    - **Secure Data**: Uses SQLCipher for encrypted Room database storage.
    - **QR Verification**: Integrated CameraX for scanning delivery verification codes.
    - **Navigation**: Built-in Google Maps navigation for optimized delivery routes.
    - **Financials**: "Collect Money" feature for cash-on-delivery orders.

## 🛠 Shared Tech Stack
- **Languages**: Kotlin
- **UI Framework**: Jetpack Compose
- **DI**: Koin
- **Networking**: Ktor / Retrofit
- **Local Storage**: Room (with SQLCipher)
- **Real-time**: SignalR & Firebase Cloud Messaging
- **Maps**: Google Maps SDK

## 🚀 Recent Key Milestones
- ✅ **Modularization**: Successfully refactored `ecommerce_app` into a multi-module project for better scalability.
- ✅ **Secure Storage**: Implemented encrypted databases in the delivery app.
- ✅ **Cash Flow Management**: Added the "Collect Money" feature for delivery personnel handling cash orders.
- ✅ **UI Refinement**: Optimized layouts and transitions for better performance across different devices.

---
*Developed by Abdullah.*
