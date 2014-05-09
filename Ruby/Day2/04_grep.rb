#!/usr/bin/env ruby

file = ARGV[0]
pattern = ARGV[1]

line_number = 1
File.readlines(file).each do |line|
	puts "#{line_number}:#{line}" if line =~ /#{pattern}/
	line_number = line_number + 1 
end
