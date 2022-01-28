<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:choose>
    <c:when test="${sessionScope.cart == null || empty sessionScope.cart.allItems}">
        <h3 class="text-danger">No item in your shopping cart</h3>
    </c:when>
    <c:otherwise>
        <table class="table table-striped table-bordered w-100">
            <thead>
            <th>#</th>
            <th>Code</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            <th></th>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.cart.allItems}" var="lineItem" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td class="product-id">${lineItem.product.id}</td>
                    <td>${lineItem.product.productName}</td>
                    <td style="text-align: center;">
                        <input type="number" class="quantity" oninput="this.value = (this.value < 0 ? 0 : this.value)"
                               min="0" value="${lineItem.product.quantity}"
                               onchange="updateCart(this.value, ${lineItem.product.msrp}, `${lineItem.product.id}-total`)"/>
                    </td>
                    <td><fmt:formatNumber pattern="#.##" value="${lineItem.product.msrp}"/></td>
                    <td id="${lineItem.product.id}-total">
                        <fmt:formatNumber pattern="#.##" value="${lineItem.total}"/>
                    </td>
                    <td style="text-align: center;">
                        <button type="button" id="remove-btn" class="ui-button"
                                onclick="removeItemFromCart(`${lineItem.product.id}`)">&#x1F5D1;
                        </button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" style="text-align: right; margin-right: 5px">Total</td>
                <td id="total-price"><fmt:formatNumber pattern="#.##" value="${sessionScope.cart.totalPrice}"/></td>
                <td style="text-align: center;">
                    <button type="button" id="clear-btn" class="ui-button" onclick="clearAll()">Clear</button>
                </td>
            </tr>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
