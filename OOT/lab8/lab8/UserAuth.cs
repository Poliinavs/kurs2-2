//------------------------------------------------------------------------------
// <auto-generated>
//     Этот код создан по шаблону.
//
//     Изменения, вносимые в этот файл вручную, могут привести к непредвиденной работе приложения.
//     Изменения, вносимые в этот файл вручную, будут перезаписаны при повторном создании кода.
// </auto-generated>
//------------------------------------------------------------------------------

namespace lab8
{
    using System;
    using System.Collections.Generic;
    
    public partial class UserAuth
    {
        public string name { get; set; }
        public Nullable<int> weight { get; set; }
        public Nullable<int> height { get; set; }
        public Nullable<int> age { get; set; }
        public int id { get; set; }
    
        public virtual UserInform UserInform { get; set; }
    }
}
