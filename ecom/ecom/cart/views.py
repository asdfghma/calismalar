from django.shortcuts import render, get_object_or_404
from .cart import Cart
from store.models import Product
from django.http import JsonResponse
from django.contrib import messages


# Create your views here.

def cart_summary(request):
    # Get the cart
    cart = Cart(request)
    cart_products = cart.get_prouds
    quantities = cart.get_quants
    totals = cart.cart_total()
    return render(request, "cart_summary.html", {"cart_products":cart_products, "quantities":quantities, "totals":totals})




def cart_add(request):
    # Get The Cart
    cart = Cart(request)

    # test for POST
    if request.POST.get('action') == 'post':
        # Get stuff
        product_id = int(request.POST.get('product_id'))
        product_qyt =   int(request.POST.get('product_qty'))
        
        # lookup product in DB
        product = get_object_or_404(Product, id=product_id)
        
        # Save to session 
        cart.add(product=product, quantity=product_qyt)

        # Get Cart Quantity
        cart_quantity = cart.__len__()

        # Return resonse
        # response = JsonResponse({'Product Name: ': product.name})
        response = JsonResponse({'qty': cart_quantity})
        messages.success(request, ("Product Added To Cart..."))

        return response




def cart_delete(request): 
    cart = Cart(request)
    if request.POST.get('action') == 'post':
        # Get stuff
        product_id = int(request.POST.get('product_id'))
        # Call delete Function in Cart
        cart.delete(product=product_id)

        response = JsonResponse({'product':product_id})
        messages.success(request, ("Item Deleted From Shopping Cart..."))
        return response
        #return redirect('cart_summary')

def cart_update(request):
    cart = Cart(request)
    if request.POST.get('action') == 'post':
        # Get stuff
        product_id = int(request.POST.get('product_id'))
        product_qyt =   int(request.POST.get('product_qty'))

        cart.update(product=product_id, quantity=product_qyt)

        response = JsonResponse({'qty':product_qyt})
        messages.success(request, ("Your Cart Has Been Update..."))
        return response
        #return redirect('cart_summary')