/* jQuery 메인 스크립트 - js/app.js */

$(document).ready(function() {
    // 서브메뉴 토글
    $('.menu-item[data-submenu]').on('click', function() {
        let submenuId = $(this).data('submenu') + '-submenu';
        $('#' + submenuId).toggleClass('show');
    });

    // 메뉴 클릭 이벤트 (화면 전환)
    $('.menu-item[data-screen], .submenu-item[data-screen]').on('click', function() {
        $(this).addClass('active');
    });

    // 출고 시 현재고 표시
    $('#product-select').on('change', function() {
        let stock = $(this).val();
        let $stockDiv = $('#current-stock');

        if (stock) {
            $stockDiv.text('현재고량: ' + stock + '개');
            if (stock > 0) {
                $stockDiv.css('background', '#e8f4f8');
            } else {
                $stockDiv.css('background', '#fee');
            }
        } else {
            $stockDiv.text('상품을 먼저 선택하세요');
            $stockDiv.css('background', '#e8f4f8');
        }
    });
});