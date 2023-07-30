import React from 'react'
import PropTypes from 'prop-types'
import Todo from './Todo'

const TodoList = (props) => {
  
  const { todos, toggleTodo } = props
  
  return(
          <ul>
            {todos.map(todo =>
              <Todo
                key={todo.id}
                {...todo}
                onClick={() => toggleTodo(todo.id)}
              />
            )}
          </ul>
        )
    }

export default TodoList
