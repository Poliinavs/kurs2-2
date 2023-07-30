interface Job {
  id: number;
  country: string;
  name: string;
  company: string;
  data: string;
  spetial: string;
  IsActive: boolean;
  graph: string;
  zan: string;
  experience: string;
  min: number;
  max: number;
  liked: boolean;
}

type JobsAction =
  | {
      type: 'ADD_JOB';
      id: number;
      country: string;
      name: string;
      company: string;
      data: string;
      spetial: string;
      IsActive: boolean;
      graph: string;
      zan: string;
      experience: string;
      min: number;
      max: number;
    }
  | {
      type: 'JOB_TODO' | 'JOB_ACTIVE';
      id: number;
    };

const jobs = (state: any, action: any) => {
  switch (action.type) {
    case 'ADD_JOB':
      return [
        ...state,
        {
          id: action.id,
          country: action.country,
          name: action.name,
          company: action.company,
          data: action.data,
          spetial: action.spetial,
          IsActive: action.IsActive,
          graph: action.graph,
          zan: action.zan,
          experience: action.experience,
          min: action.min,
          max: action.max,
          liked: false,
        },
      ];
    case 'JOB_TODO':
    case 'JOB_ACTIVE':
      return state.map((job:any) =>
        job.id === action.id ? { ...job, liked: !job.liked } : job
      );
    default:
      return state;
  }
};

export default jobs;
