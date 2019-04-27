package com.kotov.dao;

public enum RoleDistribution {
  USER_ROLE{
        public String toString(){
            return "Пользователь";
        }
    },
   SUPERADMIN_ROLE{
        public String toString(){
            return "Суперадмин";
        }
    },
    ADMIN_ROLE{
        public String toString(){
            return "Админ";
        }
    }
}
