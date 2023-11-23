package infra

import (
	"gorm.io/driver/mysql"

	"gorm.io/gorm"
)

func ConnectDB() *gorm.DB {
	dsn := ""
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})

	if err != nil {
		panic(err.Error())
	}

	return db
}
