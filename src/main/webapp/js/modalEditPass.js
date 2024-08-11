
const editPass= document.querySelector('.edit-pass')
const modalEditPass = document.querySelector('.edit-pass-modal')
const modalEditPassContainer = document.querySelector('.edit-pass-modal-container')
const closeBtn = document.querySelector('.js-modal-edit-pass-close')
const CancelBtn = document.querySelector('.cancel-edit-pass-btn')

function OpenBuyTicket() {
	console.log("hi")
	modalEditPass.classList.add('open')
}

function HideBuyTicket() {
	modalEditPass.classList.remove('open')
}

editPass.addEventListener('click', OpenBuyTicket)


closeBtn.addEventListener('click', HideBuyTicket)
CancelBtn.addEventListener('click', HideBuyTicket)
modalEditPass.addEventListener('click', HideBuyTicket)
modalEditPassContainer.addEventListener('click', function(event) { event.stopPropagation() })