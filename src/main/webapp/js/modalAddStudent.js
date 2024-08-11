/**
 * 
 */
const addStudentBtn = document.querySelector('.add-student-btn')
const modalAddStudent = document.querySelector('.add-student-modal')
const modalAddStudentContainer = document.querySelector('.add-student-modal-container')
const modalClose = document.querySelector('.js-modal-close')
const cancelAddStudentBtn = document.querySelector('.cancel-add-student-btn')

function OpenBuyTicket() {
	modalAddStudent.classList.add('open')
}

function HideBuyTicket() {
	modalAddStudent.classList.remove('open')
}

addStudentBtn.addEventListener('click', OpenBuyTicket)


modalClose.addEventListener('click', HideBuyTicket)
cancelAddStudentBtn.addEventListener('click', HideBuyTicket)
modalAddStudent.addEventListener('click', HideBuyTicket)
modalAddStudentContainer.addEventListener('click', function(event) { event.stopPropagation() })