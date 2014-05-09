#!/usr/bin/env ruby

numbers = (1..16).to_a

i = 0
numbers.each do |number|
	i = i + 1
	print "#{number} "
	print "\n" if i % 4 == 0
end
