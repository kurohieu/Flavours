$(document).ready(function () {
    $(".change-product-amount").change(function () {
        dataCartProduct = {};
        dataCartProduct.id = $(this).data("id");
        dataCartProduct.amount = $(this).val();

        var linkPost = "api/cart-product/update";

        axios.post(linkPost, dataCartProduct).then(function (res) {
            if (res.data.success) {
                location.reload();
            } else {
                swal(
                    'Fail',
                    res.data.message,
                    'error'
                ).then(function () {
                    location.reload();
                });
            }

        }, function (err) {
            swal(
                'Error',
                'Fail',
                'error'
            );
        });
    });
    $(".delete-cart-product").on("click", function () {
        var pdInfo = $(this).data("id");

        var linkDelete = "/api/cart-product/delete/" + pdInfo;
        axios.delete(linkDelete).then(function (res) {
            if (res.data.success) {
                swal(
                    'Success',
                    res.data.message,
                    'success'
                ).then(function () {
                    location.reload();
                });
            } else {
                swal(
                    'Fail',
                    res.data.message,
                    'error'
                );
            }

        }, function (err) {
            swal(
                'Error',
                'Fail',
                'error'
            );
        });
    })
});