interface Job {
  id: number;
  text: string;
  name: string;
  liked: boolean;
}

type FilterTypes =
  | 'SHOW_ALL'
  | 'SHOW_Like'
  | 'SHOW_AllDay'
  | 'SHOW_GibkGraph'
  | 'SHOW_FarWork';

let nextJobId = 4;

export const addJob = (inform:any) => ({
  type: 'ADD_JOB' as const,
  id: ++nextJobId,
  inform

});

export const setVisibilityFilter = (filter: FilterTypes) => ({
  type: 'SET_VISIBILITY_FILTER' as const,
  filter,
});

export const jobTodo = (id: number) => ({
  type: 'JOB_TODO' as const,
  id,
});

export const jobActive = (id: number) => ({
  type: 'JOB_ACTIVE' as const,
  id,
});

export const VisibilityFilters = {
  SHOW_ALL: 'SHOW_ALL' as const,
  SHOW_Like: 'SHOW_Like' as const,
  SHOW_React: 'SHOW_React' as const,
  SHOW_GRAPH1: 'SHOW_GRAPH1' as const,
  SHOW_GRAPH2: 'SHOW_GRAPH2' as const,
  SHOW_GRAPH3: 'SHOW_GRAPH3' as const,
  SHOW_Zan2: 'SHOW_Zan2' as const,
  SHOW_Zan1: 'SHOW_Zan1' as const,
  SHOW_Zan3: 'SHOW_Zan3' as const,
  SHOW_Zan4: 'SHOW_Zan4' as const,
  SHOW_Exper1: 'SHOW_Exper1' as const,
  SHOW_Exper2: 'SHOW_Exper2' as const,
  SHOW_Exper3: 'SHOW_Exper3' as const,
  SHOW_Exper4: 'SHOW_Exper4' as const,
  SHOW_City: 'SHOW_City' as const,
  SHOW_Price: 'SHOW_Price' as const,
};

export type Action =
  | ReturnType<typeof addJob>
  | ReturnType<typeof setVisibilityFilter>
  | ReturnType<typeof jobTodo>
  | ReturnType<typeof jobActive>;
