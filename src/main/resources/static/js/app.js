/* jQuery 메인 스크립트 - js/app.js */

$(document).ready(function() {
    // 서브메뉴 토글
    $('.menu-item[data-submenu]').on('click', function() {
        var submenuId = $(this).data('submenu') + '-submenu';
        $('#' + submenuId).toggleClass('show');
    });

    // 메뉴 클릭 이벤트 (화면 전환)
    $('.menu-item[data-screen], .submenu-item[data-screen]').on('click', function() {
        $(this).addClass('active');
    });

    // 출고 시 현재고 표시
    $('#product-select').on('change', function() {
        var stock = $(this).val();
        var $stockDiv = $('#current-stock');

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

    // 삭제 버튼 이벤트
    $(document).on('click', '.btn-delete', function() {
        var type = $(this).data('type');
        if (confirm('정말 이 ' + type + '을(를) 삭제하시겠습니까?\n삭제된 데이터는 복구할 수 없습니다.')) {
            alert(type + '이(가) 삭제되었습니다.');
            // 실제로는 여기서 서버에 삭제 요청
            // $.ajax({
            //     url: '/api/delete',
            //     method: 'POST',
            //     data: { id: ... },
            //     success: function() {
            //         // 성공 처리
            //     }
            // });
        }
    });

});