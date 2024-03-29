package yass.jouao.labx.entities;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yass.jouao.labx.enums.Sex;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Sex sex;
	@Column(nullable = false)
	private String phone;
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
	private Collection<Sample> samples;
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
	private Collection<Analysis> analysis;
}
