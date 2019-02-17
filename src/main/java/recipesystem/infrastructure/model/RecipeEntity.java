package recipesystem.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * レシピ情報を扱うドメインクラス.
 */
@Data
@Entity
@Table(name = "recipes")
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "title")
  private String title;
  @Column(name = "making_time")
  private String makingTime;
  @Column(name = "serves")
  private String serves;
  @Column(name = "ingredients")
  private String ingredients;
  @Column(name = "cost")
  private Integer cost;
}
