import { connect } from 'react-redux';
import { jobTodo } from '../actions';
import { jobActive } from '../actions';
import JobList from '../components/JobList';


import { Dispatch } from 'redux';

import { VisibilityFilters } from '../actions';

let _lenguage = '';
let _country = '';
let graph = '';
let zan = '';
let exper = '';

export const setLenguage = (value: string) => {
  _lenguage = value;
};

export const getLenguage = () => {
  return _lenguage;
};

export const setCountry = (value: string) => {
  _country = value;
};

export const getCountry = () => {
  return _country;
};

let a = 0;
let lg = false;

function intersect(leng: any[], like: any[]) {
  if (a > 0) {
    return like.filter((el) => leng.map((el2) => el2.id).includes(el.id));
  } else {
    return leng;
  }
}

function doFilter(jobs: any[], filter: string) {
  const leng = jobs.filter((t) => t.spetial.includes(_lenguage));
  const like = jobs.filter((t) => t.liked);
  return intersect(leng, like);
}

const getVisibleJobs = (jobs: any[], filter: string) => {
    switch (filter) {
        case VisibilityFilters.SHOW_ALL:
            a=0;
            lg=false;
            return jobs;
        case VisibilityFilters.SHOW_Like:
            a++;
            // if(!lg){
            //     console.log("+++-------++");
                return jobs.filter((t) => t.liked);

            // }
            // else
            
            // console.log(_lenguage);
            // console.log("+++++");
            // return  DoFilter(jobs,filter );
            case VisibilityFilters.SHOW_React:
                lg=true;
                return  doFilter(jobs,filter );
               // return jobs.filter((t) => t.spetial.includes(_lenguage));
               case VisibilityFilters.SHOW_City:
                return jobs.filter((t) => t.country=== getLenguage());
                case VisibilityFilters.SHOW_Price:
                  console.log(getLenguage());
                  var num = +getLenguage();
                  return jobs.filter((t) => num >= t.min && num <= t.max);
       
        case VisibilityFilters.SHOW_GRAPH1:
            graph= "poln"
            console.log(graph);
            return jobs.filter((t) => t.graph=== "poln");
        case VisibilityFilters.SHOW_GRAPH2:
                graph= "gibk"
                return jobs.filter((t) => t.graph=== graph);
        case VisibilityFilters.SHOW_GRAPH3:
           graph= "udal"
         return jobs.filter((t) => t.graph=== graph);

         case VisibilityFilters.SHOW_Zan1:
            zan= "poln"
          return jobs.filter((t) => t.zan=== zan);
          case VisibilityFilters.SHOW_Zan2:
            zan= "chast"
          return jobs.filter((t) => t.zan=== zan);
          case VisibilityFilters.SHOW_Zan3:
            zan= "proj"
          return jobs.filter((t) => t.zan=== zan);
          case VisibilityFilters.SHOW_Zan4:
            zan= "staj"
          return jobs.filter((t) => t.zan=== zan);
     

          case VisibilityFilters.SHOW_Exper1:
            exper= "no"
          return jobs.filter((t) => t.experience=== exper);
          case VisibilityFilters.SHOW_Exper2:
            exper= "one"
          return jobs.filter((t) => t.experience=== exper);
          case VisibilityFilters.SHOW_Exper3:
            exper= "thre"
          return jobs.filter((t) => t.experience=== exper);
          case VisibilityFilters.SHOW_Exper4:
            exper= "six"
          return jobs.filter((t) => t.experience=== exper);
          
        default:
            throw new Error('Unknown filter: ' + filter);
    }
};



const mapStateToProps = (state: any) => ({
  jobs: getVisibleJobs(state.jobs, state.visibilityFilter),
});

const mapDispatchToProps = (dispatch: Dispatch) => ({
  jobTodo: (id: number) => dispatch(jobTodo(id)),
});

const mapDispatchActive = (dispatch: Dispatch) => ({
  jobTodo: (id: number) => dispatch(jobTodo(id)),
});

const Container = connect(
    mapStateToProps,
    mapDispatchToProps
)(JobList)

export default Container;