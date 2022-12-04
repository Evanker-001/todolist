const form = $('#task-form')
const taskInput = $('#task')
// const filterInpuit = $('#filter')
const clearBtn = $('.clear-tasks')
const tasksUl = $('.collection')
let list = []
let listdata = []
let tasks = []
$(function(){
    startApp()
});

function startApp(){
    tasks = getData()
    show(tasks)
    startListen()
}

function getData(){
    list = []
    $.ajax({
        type:"GET",
        url:"http://localhost:9090/todolist/show",
        async: false,
        success: (res) => {
            console.log(res.data);
            list = res.data
        }
    })
    let k = 0
    listdata = []
    for (const i of list){
        listdata[k] = i.things
        k++
    }
    return listdata
}

function show(tasks){
    tasksUl.empty()
    for (const task of tasks){
        let li = document.createElement('li')
        li.className = 'collection-item'
        li.innerHTML = `${task}<a class="delete-item secondary-content"><i class="fa fa-remove"></i></a>`
        tasksUl.append(li)
    }
}

function startListen(){
    form.submit(addTask)
    tasksUl.click(removeTask)
    clearBtn.click(clearAllTask)
    //filterInpuit.keyup(filterTasks)
}

// function saveData(data){
//     localStorage.setItem("todolist",JSON.stringify(data));
// }

function addTask(e){
    const newTask = taskInput.val()
    if(!newTask){
        alert("请输入任务!!")
        return
    }

    let data = {things: newTask}
    $.ajax({
        type:"POST",
        url:"http://localhost:9090/todolist/add",
        async: false,
        data:JSON.stringify(data),
        contentType:"application/json"
    })

    tasks = getData()
    show(tasks)
    $('#task').val('')
    e.preventDefault()
}

function removeTask(e){
    if(e.target.classList.contains('fa-remove')){
        tasks = getData()
        let index = tasks.indexOf(e.target.parentNode.parentNode.firstChild.textContent)
        //saveData(tasks)
        let t = tasks[index]
        let data = {things: t}
        $.ajax({
            type:"POST",
            url:"http://localhost:9090/todolist/delete",
            async: false,
            data:JSON.stringify(data),
            contentType:"application/json"
        })
        tasks = getData()
        show(tasks)
    }
}

function clearAllTask(){
    tasks = getData()
    for (const task of tasks){
        let data = {things: task}
        $.ajax({
            type:"POST",
            url:"http://localhost:9090/todolist/delete",
            async: false,
            data:JSON.stringify(data),
            contentType:"application/json"
        })
    }
    tasks = getData()
    show(tasks)
}

// function filterTasks(e){
//     // const inputText = e.target.value.toLowerCase()
//     // tasks = getData()
//     // let filteredTasks = tasks.filter(task => task.toLocaleLowerCase().includes(inputText))
//     // show(filteredTasks)

//     const inputText = e.target.value.toLowerCase()
//     let data = {things: inputText}
//     $.ajax({
//         type:"POST",
//         url:"http://localhost:9090/todolist/select",
//         async: false,
//         data:JSON.stringify(data),
//         contentType:"application/json",
//         success: (res) => {
//             list = res.data
//         }
//     })
//     let k = 0
//     for (const i of list){
//         listdata[k] = i.things
//         k++
//     }
//     show(listdata)
// }

document.getElementById('back').addEventListener('click',function(){
    window.location.href = "mylogin.html"
})

