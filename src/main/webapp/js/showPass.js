/**
 * 
 */
const showPassIcon = document.querySelector('.show-pass')
const hidePassIcon = document.querySelector('.hide-pass')
const passShowed = document.querySelector('.account-pass-text__show')
const passhidden = document.querySelector('.account-pass-text__hide')

showPassIcon.addEventListener('click', function() {
	passhidden.classList.add("hidden")
	passShowed.classList.remove("hidden")
	showPassIcon.classList.add("hidden")
	hidePassIcon.classList.remove("hidden")
})

hidePassIcon.addEventListener('click', function() {
	passhidden.classList.remove("hidden")
	passShowed.classList.add("hidden")
	showPassIcon.classList.remove("hidden")
	hidePassIcon.classList.add("hidden")
})