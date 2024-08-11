
const addClass= document.querySelector('.add-class-btn')
const modalAddClass = document.querySelector('.add-class-modal')
const modalAddClassContainer = document.querySelector('.add-class-modal-container')
const closeModalAddClassBtn = document.querySelector('.js-modal-add-class-close')
const cancelAddClassBtn = document.querySelector('.cancel-add-class-btn')

function Open() {
	modalAddClass.classList.add('open')
}

function Hide() {
	modalAddClass.classList.remove('open')
}

addClass.addEventListener('click', Open)

closeModalAddClassBtn.addEventListener('click', Hide)
cancelAddClassBtn.addEventListener('click', Hide)
modalAddClass.addEventListener('click', Hide)
modalAddClassContainer.addEventListener('click', function(event) { event.stopPropagation() })