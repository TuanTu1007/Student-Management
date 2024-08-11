/**
 * 
 */
document.getElementById('report-type-selection').addEventListener('change', function() {
    var selected = this.value;
    var reportTypes = document.querySelectorAll('.report-type');
    var reportTypeList = document.querySelector('.report-type-list')

    reportTypes.forEach(function(reportType) {
        if (reportType.id === selected) {
            reportTypeList.classList.remove("hidden")
            reportType.style.display = 'flex';
        } else{
            reportType.style.display = 'none';
        }
    });
});