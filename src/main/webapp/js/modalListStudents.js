
const addListStudentOfClassIcons = document.querySelectorAll('.list-student-of-class-confirm-btn')
const modalListStudent = document.querySelector('.list-students-modal')
const modalListStudentContainer = document.querySelector('.list-students-modal-container')
const closeModalListStudentBtn = document.querySelector('.js-modal-list-students-close')

function Open() {
	modalListStudent.classList.add('open')
}

function Hide() {
	modalListStudent.classList.remove('open')
}

addListStudentOfClassIcons.addEventListener('click', Open)

modalListStudent.addEventListener('click', Hide)
modalListStudentContainer.addEventListener('click', function(event) { event.stopPropagation() })



closeModalListStudentBtn.addEventListener('click', Hide)
