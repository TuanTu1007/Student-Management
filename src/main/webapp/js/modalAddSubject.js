
const addSubject= document.querySelector('.add-subject-btn')
const modalAddSubject = document.querySelector('.add-subject-modal')
const modalAddSubjectContainer = document.querySelector('.add-subject-modal-container')
const closeModalAddSubjectBtn = document.querySelector('.js-modal-add-subject-close')
const cancelAddSubjectBtn = document.querySelector('.cancel-add-subject-btn')

function OpenBuyTicket() {
	modalAddSubject.classList.add('open')
}

function HideBuyTicket() {
	modalAddSubject.classList.remove('open')
}

addSubject.addEventListener('click', OpenBuyTicket)

closeModalAddSubjectBtn.addEventListener('click', HideBuyTicket)
cancelAddSubjectBtn.addEventListener('click', HideBuyTicket)
modalAddSubject.addEventListener('click', HideBuyTicket)
modalAddSubjectContainer.addEventListener('click', function(event) { event.stopPropagation() })/**
 * 
 */