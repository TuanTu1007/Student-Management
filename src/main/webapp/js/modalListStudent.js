
const confirmAddClass= document.querySelector('.confirm-add-class-btn')
const modalListStudent = document.querySelector('.list-students-modal')
const modalListStudentContainer = document.querySelector('.list-students-modal-container')
const closeModalListStudentBtn = document.querySelector('.js-modal-list-students-close')
const cancelListStudentBtn = document.querySelector('.cancel-list-students-btn')
const confirmListStudentBtn = document.querySelector('.confirm-list-students-btn')

function OpenBuyTicket() {
	modalListStudent.classList.add('open')
}

function HideBuyTicket() {
	modalListStudent.classList.remove('open')
}

confirmAddClass.addEventListener('click', OpenBuyTicket)


closeModalListStudentBtn.addEventListener('click', function() {
	document.querySelector('.add-class-modal').classList.add('open')
	modalListStudent.classList.remove('open')
})
cancelListStudentBtn.addEventListener('click', function() {
	document.querySelector('.add-class-modal').classList.add('open')
	modalListStudent.classList.remove('open')
})
confirmListStudentBtn.addEventListener('click', function() {
	document.getElementById("list-student-of-class").classList.remove("hidden")
	document.getElementById("class").classList.add("hidden")
	modalListStudent.classList.remove('open')
})
modalListStudent.addEventListener('click', HideBuyTicket)
modalListStudentContainer.addEventListener('click', function(event) { event.stopPropagation() })