
const addClass= document.querySelector('.add-class-btn')
const modalAddClass = document.querySelector('.add-class-modal')
const modalAddClassContainer = document.querySelector('.add-class-modal-container')
const closeModalAddClassBtn = document.querySelector('.js-modal-add-class-close')
const cancelAddClassBtn = document.querySelector('.cancel-add-class-btn')

function OpenBuyTicket() {
	modalAddClass.classList.add('open')
}

function HideBuyTicket() {
	modalAddClass.classList.remove('open')
}

addClass.addEventListener('click', OpenBuyTicket)

closeModalAddClassBtn.addEventListener('click', HideBuyTicket)
cancelAddClassBtn.addEventListener('click', HideBuyTicket)
modalAddClass.addEventListener('click', HideBuyTicket)
modalAddClassContainer.addEventListener('click', function(event) { event.stopPropagation() })