/**
 * 
 */
const datatablesInfoStudent = '#datatablesInfoStudent'
const datatablesClass = '#datatablesClass'
const datatablesReport = '#datatablesReport'
const datatablesSearchStudent = '#datatablesSearchStudent'
const datatablesSubject = '#datatablesSubject'
const datatablesPoint = '#datatablesPoint'
const datatablesListStudent = '#datatablesListStudent'

function Pagination(tableNameID) {
  const table = $(`${tableNameID}`);
  const rowsPerPage = 6;
  let maxPageShow = 5;

  const totalRows = table.find('tr').length - 1;
  const pageCount = Math.ceil(totalRows / rowsPerPage);
  const datatableBottom = $('<div class="datatable-bottom"></div>');
  const navPagination = $('<nav class="datatable-pagination"></nav>');
  datatableBottom.append(navPagination);
  const paginationControls = $('<ul class="datatable-pagination-list"></ul>');
  navPagination.append(paginationControls); // Đảm bảo rằng dòng này được thêm vào
  const prevBtn = $('<span class="prevBtn"><</span>');
  const nextBtn = $('<span class="nextBtn">></span>');
  navPagination.append(prevBtn);

  // Hàm để cập nhật nút phân trang
  function updatePaginationControls(currentPage) {
    paginationControls.empty(); // Xóa các nút phân trang hiện tại

    // Thêm nút trang đầu tiên và trang cuối cùng
    paginationControls.append(createPageItem(1));
    if (pageCount > maxPageShow) {
      // Tính toán trang bắt đầu và kết thúc cho các nút ở giữa
      let startPage = Math.max(2, currentPage - 1);
      let endPage = Math.min(pageCount - 1, currentPage + 1);

      // Thêm nút "..." nếu cần
      if (startPage > 2) {
        paginationControls.append(createPageItem('...'));
      }
      for (let i = startPage; i <= endPage; i++) {
        paginationControls.append(createPageItem(i));
      }
      if (endPage < pageCount - 1) {
        paginationControls.append(createPageItem('...'));
      }
    } else {
      for (let i = 2; i < pageCount; i++) {
        paginationControls.append(createPageItem(i));
      }
    }
    paginationControls.append(createPageItem(pageCount));

    // Đánh dấu nút trang hiện tại là hoạt động
    paginationControls.find('li[data-page="' + currentPage + '"]').addClass('active');
  }

   // Hàm tạo nút phân trang mới
   function createPageItem(page) {
    const pageLink = $('<li class="datatable-pagination-item" data-page="' + page + '"><a href="#">' + page + '</a></li>');
    if (page !== '...') {
      pageLink.click(function (event) {
        event.preventDefault();
        const selectedPage = parseInt($(this).data('page'));
        showPage(selectedPage);
        updatePaginationControls(selectedPage); // Cập nhật nút phân trang sau khi chuyển trang
      });
    }
    return pageLink;
  }

  navPagination.append(paginationControls);
  navPagination.append(nextBtn);
  table.after(datatableBottom);

  // Các hàm khác giữ nguyên
  function showPage(pageNumber) {
    // Tạo bản sao của phần tử 'thead'
    const theadClone = table.find('thead').clone();

    // Ẩn tất cả các hàng trong bảng
    table.find('tr').hide();

    // Hiển thị chỉ các hàng cho trang hiện tại
    const startRow = (pageNumber - 1) * rowsPerPage;
    const endRow = startRow + rowsPerPage;
    for (let i = startRow + 1; i <= endRow; i++) {
      table.find('tr:nth-child(' + i + ')').show();
    }

    // Thêm bản sao 'thead' vào đầu bảng
    table.find('thead').remove();
    table.prepend(theadClone);

    // Cập nhật liên kết trang đang hoạt động
    paginationControls.find('li').removeClass('active');
    paginationControls.find('li:nth-child(' + pageNumber + ')').addClass('active');


  }

  showPage(1);

  prevBtn.click(function (event) {
    event.preventDefault();
    const currentPage = parseInt(document.querySelector('.datatable-pagination-item.active').textContent);
    if (currentPage > 1) {
      showPage(currentPage - 1);
      updatePaginationControls(currentPage - 1); // Cập nhật nút phân trang sau khi chuyển trang
    }
  })
  nextBtn.click(function (event) {
    event.preventDefault();
    const currentPage = parseInt(document.querySelector('.datatable-pagination-item.active').textContent);
    if (currentPage < pageCount) {
      showPage(currentPage + 1);
      updatePaginationControls(currentPage + 1); // Cập nhật nút phân trang sau khi chuyển trang
    }
  })

  // Gọi hàm cập nhật nút phân trang khi trang web được tải
  updatePaginationControls(1);
}

Pagination(datatablesInfoStudent)
Pagination(datatablesClass)
Pagination(datatablesReport)
Pagination(datatablesSearchStudent)
Pagination(datatablesSubject)
Pagination(datatablesPoint)
Pagination(datatablesListStudent)