/**
 * 
 */
document.getElementById('change-rule-selection').addEventListener('change', function() {
    var selected = this.value;
    var rules = document.querySelectorAll('.rule');
    var ruleList = document.querySelector('.change-rule-list')
    console.log(selected)
    rules.forEach(function(rule) {
        if (rule.id === selected) {
            ruleList.classList.remove("hidden")
            rule.style.display = 'flex';
        } else{
            rule.style.display = 'none';
        }
    });
});