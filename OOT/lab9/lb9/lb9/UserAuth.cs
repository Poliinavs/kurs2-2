//------------------------------------------------------------------------------
// <auto-generated>
//     Этот код создан по шаблону.
//
//     Изменения, вносимые в этот файл вручную, могут привести к непредвиденной работе приложения.
//     Изменения, вносимые в этот файл вручную, будут перезаписаны при повторном создании кода.
// </auto-generated>
//------------------------------------------------------------------------------

namespace lb9
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public partial class UserAuth
    {
        public string name { get; set; }
        public Nullable<int> weight { get; set; }
        public Nullable<int> height { get; set; }
        public Nullable<int> age { get; set; }
        public int id { get; set; }

        [ForeignKey("id")]
        public virtual Mood Mood { get; set; }
    }
    public class Mood
    {
        [Key]  public int id;
        [Column("happy")]
        public string happy;
        [Column("sad")]
        public string sad;
        [Column("angry")]
        public string angry;
       
    }

}