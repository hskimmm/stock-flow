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
        let stock = $(this).find("option:selected").data('stock');
        let unit = $(this).find("option:selected").data('unit');

        console.log(stock);

        let $stockDiv = $('#current-stock');

        if (stock) {
            $stockDiv.text('현재고량: ' + stock + unit);
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

//날짜 범위 초기화(최근 1개월)
function initDateRange() {
    const startInput = $("#startDate");
    const endInput = $("#endDate");

    //검색 시 initDateRange 호출하여 값이 덮어 씌워지는 버그 방지
    if (startInput.val() && endInput.val()) return;

    const today = new Date();
    const oneMonthAgo = new Date();
    oneMonthAgo.setMonth(today.getMonth() - 1);

    const startDateStr = formatDate(oneMonthAgo);
    const endDateStr = formatDate(today);

    $("#startDate").val(startDateStr);
    $("#endDate").val(endDateStr);

    $("#endDate").attr('max', endDateStr);
}

//DATE -> YYYY-MM-DD 형식 변환
function formatDate(date) {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
}