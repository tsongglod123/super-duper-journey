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
            <th></th>
            <th>Quantity</th>
            <th></th>
            <th>Price</th>
            <th>Total</th>
            <th></th>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.cart.allItems}" var="lineItem" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${lineItem.product.id}</td>
                    <td>${lineItem.product.productName}</td>
                    <td style="text-align: center; font-family: 'Courier New', monospace;">
                        <button type="button" id="decrease-btn" class="ui-button"
                                onclick="decrease(`${lineItem.product.id}`)">-
                        </button>
                    </td>
                    <td id="${lineItem.product.id}">${lineItem.quantity}</td>
                    <td style="text-align: center; font-family: 'Courier New', monospace;">
                        <button type="button" id="increase-btn" class="ui-button"
                                onclick="increase(`${lineItem.product.id}`)">+
                        </button>
                    </td>
                    <td><fmt:formatNumber pattern="#.##" value="${lineItem.product.msrp}"/></td>
                    <td id="${lineItem.product.id}-total"><fmt:formatNumber pattern="#.##"
                                                                            value="${lineItem.total}"/></td>
                    <td style="text-align: center;">
                        <button type="button" id="remove-btn" class="ui-button"
                                onclick="removeItemFromCart(`${lineItem.product.id}`)">&#x1F5D1;
                        </button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="7" style="text-align: right; margin-right: 5px">Total</td>
                <td id="total-price"><fmt:formatNumber pattern="#.##" value="${sessionScope.cart.totalPrice}"/></td>
                <td style="text-align: center;">
                    <button type="button" id="clear-btn" class="ui-button" onclick="clearAll()">Clear</button>
                </td>
            </tr>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
