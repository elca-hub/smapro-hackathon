package model

import "gorm.io/gorm"

type User struct {
	gorm.Model

	MailAddress string `json:"mail_address"`
	Password    string `json:"password"`
	UserName    string `json:"user_name"`
	SchoolName  string `json:"school_name"`
}
