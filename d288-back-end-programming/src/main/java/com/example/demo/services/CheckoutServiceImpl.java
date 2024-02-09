package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartRepository cartRepository;

    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();

        String orderTrackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);});

        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }
}
