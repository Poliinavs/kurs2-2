interface Todo {
    id: number,
    text: string,
    completed: boolean
  }
  
  type FilterTypes = 'SHOW_ALL' | 'SHOW_COMPLETED' | 'SHOW_ACTIVE';
  
  let nextTodoId = 0;
  
  export const addTodo = (text: string) => ({
    type: 'ADD_TODO' as const,
    id: nextTodoId++,
    text
  })
  
  export const setVisibilityFilter = (filter: FilterTypes) => ({
    type: 'SET_VISIBILITY_FILTER' as const,
    filter
  })
  
  export const toggleTodo = (id: number) => ({
    type: 'TOGGLE_TODO' as const,
    id
  })
  
  export const VisibilityFilters = {
    SHOW_ALL: 'SHOW_ALL' as const,
    SHOW_COMPLETED: 'SHOW_COMPLETED' as const,
    SHOW_ACTIVE: 'SHOW_ACTIVE' as const
  }