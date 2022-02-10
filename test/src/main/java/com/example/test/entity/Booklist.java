package com.example.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xliu
 * @since 2022-02-02
 */
public class Booklist implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * ID
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 书名
     */
      private String name;

      /**
     * 作者
     */
      private String author;

      /**
     * 类型
     */
      private String type;

      /**
     * 出版时间
     */@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
      private LocalDateTime presstime;

      /**
     * 出版社
     */
      private String press;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public String getName() {
        return name;
    }

      public void setName(String name) {
          this.name = name;
      }
    
    public String getAuthor() {
        return author;
    }

      public void setAuthor(String author) {
          this.author = author;
      }
    
    public String getType() {
        return type;
    }

      public void setType(String type) {
          this.type = type;
      }
    
    public LocalDateTime getPresstime() {
        return presstime;
    }

      public void setPresstime(LocalDateTime presstime) {
          this.presstime = presstime;
      }
    
    public String getPress() {
        return press;
    }

      public void setPress(String press) {
          this.press = press;
      }

    @Override
    public String toString() {
        return "Booklist{" +
              "id=" + id +
                  ", name=" + name +
                  ", author=" + author +
                  ", type=" + type +
                  ", presstime=" + presstime +
                  ", press=" + press +
              "}";
    }
}
