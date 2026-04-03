package com.example.core.di

import com.example.core.data.repository.AddressRepository
import com.example.core.data.repository.AuthRepository
import com.example.core.data.repository.BannerRepository
import com.example.core.data.repository.CategoryRepository
import com.example.core.data.repository.CurrencyRepository
import com.example.core.data.repository.DeliveryRepository
import com.example.core.domain.repository.IDeliveryRepository
import com.example.core.data.repository.GeneralSettingRepository
import com.example.core.data.repository.MapRepository
import com.example.core.domain.repository.IMapRepository
import com.example.core.data.repository.OrderItemRepository
import com.example.core.data.repository.OrderRepository
import com.example.core.data.repository.PaymentRepository
import com.example.core.data.repository.PaymentTypeRepository
import com.example.core.domain.repository.IOrderRepository
import com.example.core.domain.repository.IPaymentRepository
import com.example.core.domain.repository.IPaymentTypeRepository
import com.example.core.data.repository.ProductRepository
import com.example.core.data.repository.StoreRepository
import com.example.core.data.repository.SubCategoryRepository
import com.example.core.data.repository.UserRepository
import com.example.core.data.repository.VariantRepository
import com.example.core.domain.repository.IAddressRepository
import com.example.core.domain.repository.IAuthRepository
import com.example.core.domain.repository.IBannerRepository
import com.example.core.domain.repository.ICategoryRepository
import com.example.core.domain.repository.ICurrencyRepository
import com.example.core.domain.repository.IGeneralSettingRepository
import com.example.core.domain.repository.IOrderItemRepository
import com.example.core.domain.repository.IProductRepository
import com.example.core.domain.repository.IStoreRepository
import com.example.core.domain.repository.ISubCategoryRepository
import com.example.core.domain.repository.IUserRepository
import com.example.core.domain.repository.IVariantRepository
import org.koin.dsl.module

val repositoryModel = module {
    single<IAddressRepository> { AddressRepository(get(), get()) }
    single<IAuthRepository> { AuthRepository(get()) }
    single<IBannerRepository> { BannerRepository(get(), get()) }
    single<ICategoryRepository> { CategoryRepository(get(), get()) }
    single<IGeneralSettingRepository> { GeneralSettingRepository(get(), get()) }
    single<IOrderItemRepository> { OrderItemRepository(get(), get()) }
    single<IOrderRepository> { OrderRepository(get(), get()) }
    single<IProductRepository> { ProductRepository(get(), get()) }
    single<IStoreRepository> { StoreRepository(get(), get()) }
    single<ISubCategoryRepository> { SubCategoryRepository(get(), get()) }
    single<IUserRepository> { UserRepository(get(), get()) }
    single<IVariantRepository> { VariantRepository(get(), get()) }
    single<IMapRepository> { MapRepository(get()) }
    single<IDeliveryRepository> { DeliveryRepository(get(), get()) }
    single<ICurrencyRepository> { CurrencyRepository(get(), get()) }
    single<IPaymentRepository> { PaymentRepository(get(), get()) }
    single<IPaymentTypeRepository> { PaymentTypeRepository(get(), get()) }
}