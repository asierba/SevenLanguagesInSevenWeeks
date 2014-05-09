number = rand(10)

puts "Guess a number between 0 and 10"

begin
	guess = gets.chomp.to_i
	
	puts "Correct! #{number} is the number" if guess == number
	puts "Too low, pick a higher number" if guess < number
	puts "Too high, pick a lower number" if guess > number
end while guess != number


